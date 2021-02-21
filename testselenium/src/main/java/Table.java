import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

public class Table {

    private final WebElement tableElement;
    private final WebDriver driver;

    public Table(WebElement tableElement, WebDriver driver){     /* конструктор: присваиваем значения переменным класса
                                                                    значения переменных конструктора*/
        this.tableElement = tableElement;
        this.driver = driver;
    }

    public List<WebElement> getRows(){                           /* список строк*/

        List<WebElement> rows = tableElement.findElements(By.xpath(".//tr")); /* находим все строки в таблице*/
        rows.remove(0);                                                 /* удаляем первую строку (с индексом 0)- заголовки*/
        return  rows;                                                         /* возвращаем список элементов- строки */
    }

    public List<WebElement> getHeadings(){                          /* получаем список заголовков*/

        WebElement headingsRow = tableElement.findElement(By.xpath(".//tr[1]"));      /* находим в таблице первую строку - заголовки*/
        List<WebElement> headingColumns = headingsRow.findElements(By.xpath(".//th"));/* создаём список заголовков,*/
        return headingColumns;                                                        /* внутри строки с заголовками находим сами заголовки*/
    }

    public List<List<WebElement>> getRowsWithColumns() {                /* разбиваем строки на колонки: получаем список списков вэб-элементов,
                                                                        каждый вэб-элемент- это колонка в строке*/

        List<WebElement> rows = getRows();                              /* получаем все строки, используя написанный ранее метод*/
        List<List<WebElement>> rowsWithColumns = new ArrayList<List<WebElement>>();     /* создаём переменную вэб-элеметов (список списков) и создаём новый массив списков*/
        for (WebElement row : rows) {                                               /* с помощью цикла пробежимся по всем строкам таблицы*/
            List<WebElement> rowWithColumns = row.findElements(By.xpath(".//td"));  /* каждую строку разбиваем на столбцы*/
            rowsWithColumns.add(rowWithColumns);                                    /* формируем список строк разбитых на столбцы*/
        }

        return rowsWithColumns;                                 /* возвращаем полный список разбитых на столбцы строк*/
    }

    public  List<Map<String, WebElement>> getRowsWithColumnsByHeadings(){      /* получаем список MAP-ов - строк, разбитых на столбцы
                                                                          и привязанных к заголовкам столбцов (находим ячейку по заголовку столбца)*/

        List<List<WebElement>> rowsWithColumns = getRowsWithColumns();       /* получаем список строк, разбитых на столбцы*/
        List<Map<String, WebElement>> rowsWithColumnsByHeadings = new ArrayList<Map<String, WebElement>>();    /* строки, разбитые на столбцы по заголовкам*/
        Map<String, WebElement> rowByHeadings;                         /* 1 строка, разбитая на столбцы по заголовкам*/
        List<WebElement> headingColumns = getHeadings();               /* получаем список заголовков солбцов, используя написанный ранее метод getHeadings*/

        for(List<WebElement> row : rowsWithColumns){                /* пробежимся по всем строкам, разбитым на столбцы*/

            rowByHeadings = new HashMap<String, WebElement>();      /*создаём новый HashMap для строки, разбитой на столбцы*/

            for(int i=0; i< headingColumns.size(); i++){            /* перебираем все колонки в строке заголовков для того, чтобы получить текст заголовка
                                                                    и привязать заголовок к конкретной колонке*/
                String heading = headingColumns.get(i).getText();   /* из всего списка заголовков берём конкретный заголовок и получаем его тест, кот. записываем в переменную*/
                WebElement cell = row.get(i);                        /* получаем ячейку из строки с тем же номером, с которым (номером строки) мы получаем заголовок*/
                rowByHeadings.put(heading, cell);                     /* используем MAP и помещаем в неё ячейку и заголовок (MAP является строкой)*/

            }

            rowsWithColumnsByHeadings.add(rowByHeadings);          /* в список строк с заголовками помещаем нужную нам строку*/
        }
        return  rowsWithColumnsByHeadings;                        /* возвращаем список строк-разбитых-на-столбцы-по-заголовкам*/

    }

    public String getValueFromCell(int rowNumber, int columnNumber){        /* метод, позволяющий найти ячейку таблицы по номеру строки и номеру столбца
                                                                              и получить её значение */
            List<List<WebElement>> rowsWithColumns = getRowsWithColumns(); /* создаём переменную "строки-с-колонками" и вызовем метод "получить-строки-с-колонками"*/
            WebElement cell = rowsWithColumns.get(rowNumber-1).get(columnNumber-1);/* получаем значение ячейки по ноиеру строки и номеру ячейки*/
            return cell.getText();                                                  /*возвращаем значение ячейки в виде текста*/

    }

    public String getValueFromCell(int rowNumber, String columnName) {                 /* получаем значение ячейки по номеру строки и заголовку столбца*/

        List<Map<String, WebElement>> rowsWithColumnsByHeadings = getRowsWithColumnsByHeadings(); /* получаем строки-со-столбцами-привязянными-к-заголовкам*/
        return rowsWithColumnsByHeadings.get(rowNumber - 1).get(columnName).getText();            /* возвращаем (получаем строку по номеру строки,
                                                                                                    из которой получаем нужную нам ячейку по имени столбца
                                                                                                    и из неё получаем текст)*/
    }
}
