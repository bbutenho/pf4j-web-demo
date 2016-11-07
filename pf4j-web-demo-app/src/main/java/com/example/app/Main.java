package com.example.app;

import org.glassfish.grizzly.http.server.HttpServer;

import ro.fortsoft.pf4j.DefaultPluginManager;
import ro.fortsoft.pf4j.PluginManager;
import ro.fortsoft.pf4j.PluginWrapper;

import com.example.api.RestExt;
import com.example.web.WebResources;

import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * Main class.
 *
 */
public class Main {

	public static void main(String[] args) throws IOException {
		
        final PluginManager pluginManager = new DefaultPluginManager();
        pluginManager.loadPlugins();
        pluginManager.startPlugins();
        
		List<RestExt> extList = (List<RestExt>) pluginManager.getExtensions(RestExt.class);
        System.out.println(String.format("Found %d extensions for extension point '%s'", extList.size(), RestExt.class.getName()));
        
        if(!extList.isEmpty()) {
        	WebResources.restExtension = extList.get(0);
        }
        
        // print extensions from classpath (non plugin)
        System.out.println(String.format("Extensions added by classpath:"));
        Set<String> extensionClassNames = pluginManager.getExtensionClassNames(null);
        for (String extension : extensionClassNames) {
            System.out.println("   " + extension);
        }

        // print extensions for each started plugin
        List<PluginWrapper> startedPlugins = pluginManager.getStartedPlugins();
        for (PluginWrapper plugin : startedPlugins) {
            String pluginId = plugin.getDescriptor().getPluginId();
            System.out.println(String.format("Extensions added by plugin '%s':", pluginId));
            extensionClassNames = pluginManager.getExtensionClassNames(pluginId);
            for (String extension : extensionClassNames) {
                System.out.println("   " + extension);
            }
        }

        // start server and wait for shutdown
        final HttpServer server = WebServer.startServer();
        System.in.read();
        
        // stop the plugins and server
        pluginManager.stopPlugins();
        server.shutdownNow();
    }
	
}

