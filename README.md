# TestTask
Test task for Vigo.

Программа берёт статистику из текстового файла, где записанны данные в формате <номер ячейки, год, частота встречи года в файле>,
и на его основе составляет новую статистику в таком же формате.

Информация изымается из файла по пути: src/main/resources/input/1.txt

Информация записывается в файл по пути: src/main/resources/output/statistika.txt

Пути к файлам вынесены в отдельный файл properties.properties

Из первоначального кода удалён вложенный класс, убраны лишние объявления переменных, добавлены геттер и сеттер, изменены типы некоторых переменных, переписаны некоторые циклы, 
конструктор класса изменен на дефолтный, добавлен класс с инициализацией переменных путей.
