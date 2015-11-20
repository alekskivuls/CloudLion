package cloudlion.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.pac4j.core.client.Clients;
import org.pac4j.core.config.Config;
import org.pac4j.core.context.J2EContext;
import org.pac4j.core.context.WebContext;
import org.pac4j.core.exception.RequiresHttpAction;
import org.pac4j.core.profile.ProfileManager;
import org.pac4j.core.profile.UserProfile;
import org.pac4j.oauth.client.Google2Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Application {

    @Autowired
    private Config config;

    @RequestMapping("/auth.html")
    public String index(HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) throws RequiresHttpAction {
        final WebContext context = new J2EContext(request, response);
        map.put("profile", getStringProfile(context));
        final Clients clients = config.getClients();
        final Google2Client google2Client = (Google2Client) clients.findClient(context, "Google2Client");
        map.put("urlGoogle", (String) google2Client.getRedirectAction(context, false).getLocation());
        //map.put("urlForm", (String) formClient.getRedirectAction(context, false).getLocation());
        return "auth";
    }

    private UserProfile getProfile(WebContext context) {
        final ProfileManager manager = new ProfileManager(context);
        return manager.get(true);
    }

    private String getStringProfile(WebContext context) {
        final UserProfile profile = getProfile(context);
        if (profile == null) {
            return "";
        } else {
            return profile.toString();
        }
    }

    @RequestMapping("/google/auth.html")
    public String facebook(HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
        return protectedIndex(request, response, map);
    }

    @RequestMapping("/google/notprotected.html")
    public String facebookNotProtected(HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
        final WebContext context = new J2EContext(request, response);
        map.put("profile", getStringProfile(context));
        return "notProtected";
    }

    @RequestMapping("/googleadmin/auth.html")
    public String facebookadmin(HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
        return protectedIndex(request, response, map);
    }

    @RequestMapping("/googlecustom/auth.html")
    public String facebookcustom(HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
        return protectedIndex(request, response, map);
    }

//    @RequestMapping("/form/index.html")
//    public String form(HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
//        return protectedIndex(request, response, map);
//    }

    @RequestMapping("/protected/auth.html")
    public String protect(HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
        return protectedIndex(request, response, map);
    }

//    @RequestMapping("/theForm")
//    public String theForm(HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
//        final WebContext context = new J2EContext(request, response);
//        final FormClient formClient = (FormClient) config.getClients().findClient(context, "FormClient");
//        map.put("callbackUrl", formClient.getCallbackUrl());
//        return "form";
//    }

    protected String protectedIndex(HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
        final WebContext context = new J2EContext(request, response);
        map.put("profile", getStringProfile(context));
        return "protectedIndex";
    }
}
