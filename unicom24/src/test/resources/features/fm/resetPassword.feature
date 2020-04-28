# language: ru
@resetPassword @b2c

Функционал: Восстановление пароля - финмаркет

  @test @mock @id-43
  @Severity(Critical)
  Сценарий: Восстановление пароля по СМС
    Дано пользователь находится на главной странице
    Когда пользователь нажимает на кнопку войти
    Тогда отображается страница авторизации
    Когда пользователь нажимает: забыли пароль
    Тогда открывается форма восстановления пароля
    Когда пользователь вводит телефон зарегистрированного пользователя, нажать "Отправить"
    Тогда в поле ввода появится подсказка "Пароль из смс"
    И под полем ввода ссылка "для повторного запроса sms осталось"
    И название кнопки изменится на "Войти"
    Когда пользователь вводит пароль из смс и нажимает на "Войти"
    Тогда в шапке сайта видно Ваш баланс и Ваш рейтинг
    И все элементы главной страницы видны

  @test @mock @id-28
  @Severity(Critical)
  Сценарий: Восстановление пароля по почте
    Дано пользователь находится на странице восстановления пароля
    Тогда открывается форма восстановления пароля
    Когда пользователь вводит email зарегистрированного пользователя, нажать Отправить
    Тогда отображается уведомление "Письмо с дальнейшими инструкциями успешно отправлено!"
    Когда пользователь переходит по ссылке из письма для смены пароля
    Тогда выводится форма восстановления пароля с полем для ввода пароля и полем для повторного ввода пароля
    И пользователь вводит новый пароль и нажимает Сохранить
    Тогда пользователь авторизован
    И все элементы главной страницы видны

  @test @id-100
  @Severity(low)
  Сценарий: Вывод ошибок при восстановлении пароля
    Дано пользователь находится на странице восстановления пароля
    Тогда открывается форма восстановления пароля
    Когда пользователь вводит номер несуществующего пользователя и нажимает Отправить
    Тогда отображается ошибка "Пользователя с таким номером телефона не существует"
    Когда пользователь вводит некорректный номер и нажимает отправить
    Тогда отображается ошибка "Введите корректный E-mail или телефон"
    Когда пользователь вводит почту несуществующего пользователя и нажимает Отправить
    Тогда отображается ошибка "Пользователь с указанным email не найден"
    Когда пользователь вводит некорректный мэил и нажимает отправить
    Тогда отображается ошибка "Поле должно быть действительным электронным адресом"