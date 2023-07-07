// dllmain.cpp : Definiuje punkt wejścia dla aplikacji DLL.
//#include "pch.h"
#include <C:\Program Files\Java\jdk-17\include\jni.h>
#include <iostream>

JNIEXPORT jobjectArray JNICALL Java_pl_edu_pwr_pdabrowski_Splot2DInCPP_calculate(JNIEnv* env, jclass obj, jobjectArray kernel, jobjectArray matrix){
    jint kernelRows = env->GetArrayLength(kernel);
    jint kernelCols = env->GetArrayLength((jobjectArray)env->GetObjectArrayElement(kernel, 0));

    jint matrixRows = env->GetArrayLength(matrix);
    jint matrixCols = env->GetArrayLength((jobjectArray)env->GetObjectArrayElement(matrix, 0));

    jobjectArray result = env->NewObjectArray(matrixRows, env->GetObjectClass(matrix), nullptr);

    for (int i = 0; i < matrixRows; i++) {
        jobjectArray row = (jobjectArray)env->GetObjectArrayElement(matrix, i);
        jintArray newRow = env->NewIntArray(matrixCols);
        jint* newRowData = env->GetIntArrayElements(newRow, nullptr);

        for (int j = 0; j < matrixCols; j++) {
            jintArray kernelRow = (jintArray)env->GetObjectArrayElement(kernel, i);
            jint* kernelRowData = env->GetIntArrayElements(kernelRow, nullptr);

            jintArray matrixCol = (jintArray)env->GetObjectArrayElement(matrix, j);
            jint* matrixColData = env->GetIntArrayElements(matrixCol, nullptr);

            jint sum = 0;

            for (int k = 0; k < kernelRows; k++) {
                for (int l = 0; l < kernelCols; l++) {
                    int rowIndex = i + k - kernelRows / 2;
                    int colIndex = j + l - kernelCols / 2;

                    if (rowIndex >= 0 && rowIndex < matrixRows && colIndex >= 0 && colIndex < matrixCols) {
                        jintArray kernelRow = (jintArray)env->GetObjectArrayElement(kernel, k);
                        jint* kernelRowData = env->GetIntArrayElements(kernelRow, nullptr);

                        jintArray matrixCol = (jintArray)env->GetObjectArrayElement(matrix, colIndex);
                        jint* matrixColData = env->GetIntArrayElements(matrixCol, nullptr);

                        sum += kernelRowData[l] * matrixColData[rowIndex];

                        env->ReleaseIntArrayElements(matrixCol, matrixColData, 0);
                        env->ReleaseIntArrayElements(kernelRow, kernelRowData, 0);
                    }
                }
            }

            newRowData[j] = sum;

            env->ReleaseIntArrayElements(matrixCol, matrixColData, 0);
            env->ReleaseIntArrayElements(kernelRow, kernelRowData, 0);
        }

        env->SetObjectArrayElement(result, i, newRow);

        env->DeleteLocalRef(newRow);
        env->DeleteLocalRef(row);
    }

    return result;
}