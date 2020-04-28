package api;

import org.jsoup.Connection;
import org.jsoup.helper.HttpConnection;
import org.jsoup.nodes.Document;
import pages.auth.AuthPage;
import pagesUrls.PagesUrls;
import testContext.TestContext;

import java.io.IOException;

public class AdminBalance {

    public static void runClass() throws IOException {
        if (TestContext.NonMainTestUser == 0) {
        auth(); }
    }

    public static void auth() throws IOException {
        Connection connection = HttpConnection.connect(PagesUrls.adminkaLogIn())
                .ignoreHttpErrors(true)
                .userAgent("Chrome/4.0.249.0 Safari/532.5");
        Connection.Response response = connection.execute();
        String token = response.parse().select("input[name='csrfmiddlewaretoken']").attr("value");

        Connection logInConnection = connection.url(PagesUrls.adminkaLogIn())
                .cookies(response.cookies())
                .header("Referer", PagesUrls.adminkaLogIn())
                .header("{'Cookie'", "f'csrftoken={r.cookies[" + token + "]}'}")
                .ignoreHttpErrors(true)
                .data("csrfmiddlewaretoken", token)
                .data("username", AuthPage.login)
                .data("password", AuthPage.password)
                .data("next", "/_ad_min_24/")
                .method(Connection.Method.POST)
                .followRedirects(true);
        Connection.Response connectionToLogIn = logInConnection.url(PagesUrls.adminkaLogIn()).execute();

        Connection.Response responseToGetId = logInConnection.url(PagesUrls.adminkaGetBalanceId(AuthPage.login)).execute();
        String balanceId = responseToGetId.parse().select(".field-id a").text();

        Connection.Response response4 = logInConnection.url(PagesUrls.adminkaTransactions()).execute();
        String token1 = response4.parse().select("input[name='csrfmiddlewaretoken']").attr("value");

        Connection connectionToAddBalance = logInConnection.url(PagesUrls.adminkaTransactions())
                .data("csrfmiddlewaretoken", token1)
                .data("balance", balanceId)
                .data("description", "")
                .data("payment_type", "FUNDING")
                .data("responsible", "278708")
                .data("transaction_type", "+")
                .data("sum_real", "30000")
                .data("confirmation_document", "")
                .data("basement_ct", "")
                .data("basement_pk", "")
                .data("_addanother", "")
                .method(Connection.Method.POST)
                .followRedirects(false);

        Connection.Response responseToAddBalance = connectionToAddBalance.url(PagesUrls.adminkaTransactions()).execute();


        Document tt2 = responseToAddBalance.parse();
        System.out.println(tt2);
    }

}