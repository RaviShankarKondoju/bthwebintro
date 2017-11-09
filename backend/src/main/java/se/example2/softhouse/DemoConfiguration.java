package se.example2.softhouse;

import com.bazaarvoice.dropwizard.assets.AssetsBundleConfiguration;
import com.bazaarvoice.dropwizard.assets.AssetsConfiguration;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import se.example2.softhouse.Note.Note;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by hxs on 2016-08-16.
 */
public class DemoConfiguration extends Configuration implements AssetsBundleConfiguration{

    private Note defaultNote;

    public Note getDefaultNote() {
        return defaultNote;
    }

    @Valid
    @NotNull
    @JsonProperty
    private final AssetsConfiguration assets = new AssetsConfiguration();

    @Valid
    @NotNull
    @JsonProperty
    private DataSourceFactory database = new DataSourceFactory();

    public DataSourceFactory getDataSourceFactory() {
        return database;
    }

    public AssetsConfiguration getAssetsConfiguration() {
        return assets;
    }
}
