package steps.frontend;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;

import org.apache.http.message.BasicNameValuePair;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginbypasssteps {
	
	public void log()
	{
		CookieStore cookieStore = new BasicCookieStore();
		// Create local HTTP context
		HttpClientContext localContext = HttpClientContext.create();
		// Bind custom cookie store to the local context
		localContext.setCookieStore(cookieStore);
		HttpGet httpget = new HttpGet("https://www.hepsiburada.com/ayagina-gelsin/giris");
		System.out.println("Executing request " + httpget.getRequestLine());
		httpclient.start();
		// Pass local context as a parameter
		Future<HttpResponse> future = httpclient.execute(httpget, localContext, null);

	}

}
