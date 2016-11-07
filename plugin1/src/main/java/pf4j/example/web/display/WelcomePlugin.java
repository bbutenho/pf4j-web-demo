package pf4j.example.web.display;

import ro.fortsoft.pf4j.Extension;
import ro.fortsoft.pf4j.Plugin;
import ro.fortsoft.pf4j.PluginWrapper;
import ro.fortsoft.pf4j.PluginException;

import com.example.api.RestExt;

public class WelcomePlugin extends Plugin {

    public WelcomePlugin(PluginWrapper wrapper) {
        super(wrapper);
    }

    @Override
    public void start() throws PluginException {
        System.out.println("WelcomePlugin.start()");
    }

    @Override
    public void stop() throws PluginException {
        System.out.println("WelcomePlugin.stop()");
    }

    @Extension
    public static class WelcomeGreeting implements RestExt {

    	public String getIt() {
            return "Welcome";
        }

    }

}
