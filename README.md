## Садовский А.Д. @aleks_wb_spb
___
___

## Описание работы:
___
### При разработке было найдено 2 решения.

Решение № 1 (Не реализованное)  [Ссылка на источник]( https://ru.stackoverflow.com/questions/624133/%D0%9D%D0%B5%D1%87%D0%B5%D1%82%D0%BA%D0%B8%D0%B9-%D0%BF%D0%BE%D0%B8%D1%81%D0%BA-%D0%BF%D0%BE%D0%B4%D1%81%D1%82%D1%80%D0%BE%D0%BA%D0%B8-%D0%B2-%D1%81%D1%82%D1%80%D0%BE%D0%BA%D0%B5)
1. Разбиваем строку на лексемы/слова
2. Полученные лексемы прогоняем через Apache Lucene c русской морфологией - в итоге получаем список лексем очищенный от падежных/родовых и прочих морфологичечких признаков
3. Далее для этих лексем вычисляем хэш функцию умеющую выдавать близкие значения хэша для похожих слов - например SimHash или что-то вроде упомянутого Левенштейна
   (пример поиска есть в роекте, LevenshteinSearch.class)

Решение № 2 (Реализовано)
Решение 2 - упрощенный сценарий решения 1.
1. Для поиска слов в предложении (запросе) используется "String.contains".При отсутствии совпадения происходит «усечение» слова, что бы отбросить окончание.
2. Далее составляется матрица по совпадениям слов, где значения в матрице это число совпадении.
3. Полученные значения используются для анализа и вывода поиска.

## Условие: