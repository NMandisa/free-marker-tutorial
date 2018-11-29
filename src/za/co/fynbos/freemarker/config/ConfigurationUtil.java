package za.co.fynbos.freemarker.config;

import java.util.Locale;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;

public class ConfigurationUtil {
	// Configurations FreeMarker
    // You should do this ONLY ONCE, when your application starts,
    // then reuse the same Configuration object elsewhere.
	private static Configuration configuration;
	static {
		// recommended settings:
		configuration = new Configuration(Configuration.VERSION_2_3_28);
		// Where do we load the templates from:
		ClassTemplateLoader loader = new ClassTemplateLoader(new ConfigurationUtil().getClass(), "templates");
		configuration.setTemplateLoader(loader);
		configuration.setDefaultEncoding("UTF-8");
		configuration.setLocale(Locale.US);
		configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
	}

	public static Configuration getConfiguration() {
		return configuration;
	}
}