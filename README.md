[![Build project on pr and push](https://github.com/pjwstkIOprojekt/backend/actions/workflows/build_on_pr_and_push.yml/badge.svg)](https://github.com/pjwstkIOprojekt/backend/actions/workflows/build_on_pr_and_push.yml)

### Git workflow

1. Sforkuj to repozytorium
2. Skonfiguruj gita aby podpisywał commity twoim imieniem, nazwiskiem i uczelnianym mailem
   1. `git config --global user.name "FIRST_NAME LAST_NAME"`
      - Przykład: `git config --global user.name "Jan Kowalski"`
   2. `git config --global user.email "sxxxx@pjwstk.edu.pl"`
   3. Przydatna lektura nt. tego, jak ludzie korzystają z gita (https://git.wiki.kernel.org/index.php/CommitMessageConventions)
      1. Nie jest wymagane, aby się stosować kropka w kropkę do reguł losowych przektów z tej strony, link bardziej jako inspiracja do wzorowania się
3. Przejdź do swojego forka, skopiuj URL do klonowania i sklonuj repozytorium
4. Prawdopodobnie będziesz trzeba zrobić branch, np: `git checkout -b #ticket_id_name`
5. Przed każdym commitem pamiętaj, aby napisać testy i sprawdzić, czy projekt dalej poprawnie się buduje w czystym środowisku (patrz: sekcja uruchamianie)
6. Jeśli ktoś oprócz ciebie pracował nad kodem, dodaj go jako co-author https://stackoverflow.com/questions/7442112/how-to-attribute-a-single-commit-to-multiple-developers
7. Po wprowadzeniu kilku lub jednego commita zrób `git push`
8. Jeśli praca nad daną funkcją jest skończona to należy zrobić pull request (wejdź na URL _oryginalnego_ repozytorium i przejdź do zakładki pull requests, w UI jest wszystko opisane)
9. _Ktoś_ zaakceptuje i zmerguje te zmiany _kiedyś_

### Keycloak

Uruchom keycloak w dockerze

   ```shell
   docker run -p 8081:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:17.0.1 start-dev
   ```
Przejdź w przeglądarce na adres: http://localhost:8081

Wejdź w admin panel

Po zalogowaniu (admin:admin) wybierz "Master" -> "add realm"

Zaimportuj plik `realm-export.json` z tego repozytorium

W realm dev przejdź do "Clients" i wybierz "backend"

W zakładce credentials kliknij "regenerate secret" i zapisz sobie gdzieś wygenerowany token, przyda się później

### Uruchamianie

Aplikacja wymaga połączenia do serwera keycloak oraz java 17.

#### Ustawienie środowiska

W pliku `environment.properties` są ustawienia zmiennych środowiskowych

Ich nazwy są (mam nadzieję) jasne, należy ustawić je na poprawne dla twojej konfiguracji wartości

#### W intellij:

Na prawym panelu jest zakładka "Gradle", Tasks -> application -> run

#### W terminalu:

`./gradlew run`

### Debugowanie

Plik `environment.properties` posiada zmienną `SHOW_SQL`, jeśli chcesz zobaczyć co konkretnie dzieje się w bazie danych,
ustaw ją na `true`

Dodatkowo w pliku `src/main/resources/application.yml` istnieje możliwość konfiguracji innych funkcji, takich jak poziom
loggingu poszczególnych komponentów/modułów aplikacji

#### Unit testing:

#### W intellij:

Na prawym panelu jest zakładka "Gradle", Tasks -> verification -> run

#### W terminalu:

`./gradlew test`
