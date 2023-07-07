module pl.edu.pwr.pdabrowski.provider {
    requires pl.edu.pwr.pdabrowski.api;

    provides pl.edu.pwr.pdabrowski.api.AnalysisService with pl.edu.pwr.pdabrowski.provider.Analyser;
    exports pl.edu.pwr.pdabrowski.provider;
}