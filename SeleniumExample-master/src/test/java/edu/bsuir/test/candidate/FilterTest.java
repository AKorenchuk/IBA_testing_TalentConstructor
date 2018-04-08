package edu.bsuir.test.candidate;

public class FilterTest {
    /*
    * -при нажатиии на кнопку очистка фильтров, полагаю, что должны отоюразиться все имеющиеся кандидаты
    * -для всех полей фильтра убедиться в правильности результата
    *   (не понятно, по какому принципу выстраивается очередь в списке кандидатов, попадающих под данный фильтр)
    * - проверить, что ПОСЛЕ создания кандидата, его 'Университет" имеется в фильтре(раздел 'университеты')
    *            (он либо там уже был, либо должен появится, если это первый студент из этого университета)(аналогично с компетенциями)
    * -при выборе всех фильтров одновременно ---- отображаются все кандидаты
    *
    * !!! фильтр работает вместе со строкой поиска
    * -- в таком случае, при переходе к профилю отфильтрованного(фильтр +поиск)
     *   кандидата и возвращению на страницу со списком кандидатов строка поиска очищается, фильтры остаются
    * -- при переходе к профилю отфильтрованного(фильтр) кандидата и возвращению на страницу
     *   со списком кандидатов по нажатию "назад к списку кандидатов"  фильтры очищаются -- так не должно быть
    *
    *Хорошая ссылка о тестировании  фильтров:  https://habrahabr.ru/company/sibirix/blog/210542/
    * */
}