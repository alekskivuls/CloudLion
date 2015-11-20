package cloudlion.config;

import org.pac4j.core.authorization.RequireAnyRoleAuthorizer;
import org.pac4j.core.client.Clients;
import org.pac4j.core.config.Config;
import org.pac4j.oauth.client.Google2Client;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cloudlion.authorizer.CustomAuthorizer;

@Configuration
public class Pac4jConfig {

	@Bean
	public Config config() {
		// final OidcClient oidcClient = new OidcClient();
		// oidcClient.setClientID("343992089165-sp0l1km383i8cbm2j5nn20kbk5dk8hor.apps.googleusercontent.com");
		// oidcClient.setSecret("uR3D8ej1kIRPbqAFaxIE3HWh");
		// oidcClient.setDiscoveryURI("https://accounts.google.com/.well-known/openid-configuration");
		// oidcClient.addCustomParam("prompt", "consent");

		final Google2Client google2Client = new Google2Client(
				"409453998529-jiotjl7le1lqmji8f3jovil4hh34u5br.apps.googleusercontent.com", "nb2L2vwkHk6CdIlrWuYvqt2j");

		// HTTP
		// final FormClient formClient = new
		// FormClient("http://localhost:8080/theForm.jsp",
		// new SimpleTestUsernamePasswordAuthenticator());
		// final IndirectBasicAuthClient indirectBasicAuthClient = new
		// IndirectBasicAuthClient(
		// new SimpleTestUsernamePasswordAuthenticator());

		final Clients clients = new Clients("http://localhost:8080/callback", google2Client);

		final Config config = new Config(clients);
		config.addAuthorizer("admin", new RequireAnyRoleAuthorizer("ROLE_ADMIN"));
		config.addAuthorizer("custom", new CustomAuthorizer());
		return config;
	}
}
