package reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyFileReader {

    public List<String> readFileLinesList(String path) {

        //lista do której wpakujemy odczytane linijki
        List<String> result = new ArrayList<>();

        //obiekt do odczytywania tekstu z pliku
        BufferedReader reader = null;

        try {
            //tworzenie obiektu
            reader = new BufferedReader(new FileReader(path));

            //zmienna w której będziemy tymczasowo przechowywać kolejną linię, żeby sprawdzić czy jest nullem
            String line;

            //metoda readLine zwórci najpierw pierwszą linijkę z pliku i z każdym wywołaniem przejdzie do kolejnej
            //kiedy dojdzie do końca pliku zwróci 'null' i to będzie znak, że cały plik został odczytany
            while ((line = reader.readLine()) != null) {

                //dodajemy odczytaną linijkę do listy
                result.add(line);
            }


        } catch (IOException e) {

            //jeśli zostanie rzucony wyjątek (nastąpi błąd) to wypisujemy jego komunikat na konsolę
            e.printStackTrace();

        }



        try {

            //obiekt BufferedReader i ogólnie wszystkie obiekty do operacji IO mają to do siebie
            //że po skończonej pracy należy je 'zamknąć', czyli zamknąć plik z którego obiekt korzystał
            //żeby umożliwić innym podmiotem z niego korzystać.
            if (reader != null) {
                reader.close();
            }

        } catch (IOException e) {

            //jeśli zostanie rzucony wyjątek (nastąpi błąd) to wypisujemy jego komunikat na konsolę
            e.printStackTrace();
        }


        return result;

    }

}
