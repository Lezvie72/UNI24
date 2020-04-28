package stepDefinitions.webMaster.tabsStepDefinitions;

import base.Base;
import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import pages.partnerCabinetPage.Tabs.ReportsTab.*;
import pages.partnerCabinetPage.Tabs.ReportsTab.Trafic.*;

public class ReportsTabPageStepDefinitions extends Base {
    private final ReportsTabPage reportsTabPage = new ReportsTabPage();
    private final Summary summary = new Summary();
    private final Union union = new Union();
    private final Detailed detailed = new Detailed();
    TotalReport totalReport = new TotalReport();
    ChangeBalanceTabPage changeBalanceTabPage = new ChangeBalanceTabPage();
    LandingsAndAPI landingsAndAPI = new LandingsAndAPI();
    ProductsTabPage productsTabPage = new ProductsTabPage();
    DinamicLandingTabPage dinamicLandingTabPage = new DinamicLandingTabPage();

    @Дано("^вебмастер выбирает в отчетах таб (.*)$")
    public void webMasterReportsTrafficSelectMainFilter(String nameMainFilter) {
        totalReport.selectMainFilter(nameMainFilter);
    }

    @Тогда("^вебмастеру отображается результат выборки (.*) в отчетах$") // основные фильтры сводных отчетов
    public void webMasterReportsTrafficMainFilterIsDisplayed(String nameMainFilter) {
        switch (nameMainFilter) {
            case ("Единый оффер"):
                union.pageIsDisplayed();
                break;
            case ("Детализированный"):
                detailed.pageIsDisplayed();
                break;
            case ("Сводный"):
                summary.pageIsDisplayed();
                break;
        }

    }

    @Дано("^вебмастер выбирает вкладку \"([^\"]*)\" в отчетах$")
    public void webMasterReportsTabClick(String tabName){
        reportsTabPage.selectTypeReports(tabName);
    }

    @Тогда("^вебмастеру отображается вкладка \"([^\"]*)\" в отчетах$") // сами табы Отчетов
    public void webMasterReportsTabIsDisplayed(String tabName){
        switch (tabName) {
            case ("Сводный отчет"):
                union.pageIsDisplayed();
                break;
            case ("Изменение баланса"):
                changeBalanceTabPage.pageIsDisplayed();
                break;
            case ("Лендинги и API"):
                landingsAndAPI.pageIsDisplayed();
                break;
            case ("Продукты"):
                productsTabPage.pageIsDisplayed();
                break;
            case ("Динамический лендинг"):
                dinamicLandingTabPage.pageIsDisplayed();
                break;
        }
    }
}
