# language: ru
@formOfferSmall

Функционал: Проверка персонального подбора

  @test
  @TestCaseId("62")
  @Severity(Critical)
  Сценарий: Проверка персонального подбора авторизованным пользователем
    Дано пользователь находится на главной странице
    И все элементы главной страницы видны
    Когда пользователь нажимает на кнопку войти
    Тогда отображается страница авторизации
    И пользователь авторизовывается
    И пользователь авторизован
    Когда пользователь переходит на страницу персонального подбора Кредита
    Тогда отображается страница персонального подбора
    Когда пользователь кликает на кнопку Подобрать на странице персонального подбора
    Тогда отображается модальное окно обработки персональных данных на странице персонального подбора
    И отображается страница результатов персонального подбора

  @test
  @TestCaseId("63")
  @Severity(Critical)
  Сценарий: Проверка персонального подбора не авторизованным пользователем
    Когда пользователь переходит на страницу персонального подбора Кредита
    Тогда отображается страница персонального подбора
    И пользователь вводит данные на странице персонального подбора
    Когда пользователь кликает на кнопку Подобрать на странице персонального подбора
    Тогда пользователь видит форму ввода кода из смс на странице персонального подбора
    И пользователь вводит код из смс в форму на странице персонального подбора
    Когда пользователь кликает далее в форме ввода смс на странице персонального подбора
    Тогда отображается модальное окно обработки персональных данных на странице персонального подбора
    И отображается страница результатов персонального подбора