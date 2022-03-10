### Wprowadzanie zmian

1. Sforkuj to repozytorium
2. Skonfiguruj git'a aby podpisywał commity twoim imieniem, nazwiskiem i uczelnianym mailem
   1. `git config --global user.name "FIRST_NAME LAST_NAME"`
   2. `git config --global user.email "sxxxx@pjwstk.edu.pl"`
   3. Przydatna lektura nt. tego jak ludzie korzystają z git'a (https://git.wiki.kernel.org/index.php/CommitMessageConventions)
      1. Nie jest wymagane aby się stosować kropka w kropkę do reguł losowych przektów z tej strony, link bardziej jako inspiracja do wzorowania się
3. Przejdź do swojego forka, skopiuj URL do klonowania i sklonuj repozytorium
4. Prawdopodobnie będziesz potrzebować zrobić branch, np: `git checkout -b #ticket_id_name`
5. Przed każdym commitem pamiętaj aby napisać testy i sprawdzić czy projekt dalej poprawnie się buduje w czystym środowisku (patrz: sekcja uruchamianie)
6. Jeśli ktoś oprócz ciebie pracował nad kodem, dodaj go jako co-author https://stackoverflow.com/questions/7442112/how-to-attribute-a-single-commit-to-multiple-developers
7. Po wprowadzeniu kilku lub jednego commita zrób `git push`
8. Jeśli praca nad daną funkcją jest skończona to należy teraz zrobić pull request (wejdź na URL _oryginalnego_ repozytorium i przejdź do zakładki pull requests, w UI jest wszystko opisane)
9. _Ktoś_ zaakceptuje i zmerguje te zmiany _kiedyś_

### Uruchamianie

Są dwa sposoby, w czasie pracy gdy wprowadzasz zmiany i chcesz aby wszystko się szybko kompilowało:

1. Sklonuj to repozytorium
2. Wykonaj `./gradlew bootJar && docker-compose up --build -f docker-compose.devBuild.yml`
3. Aplikacja powinna być dostępna pod portem `8080`, dodatkowo włączony jest agent debugowania na porcie `5005`
4. Jeśli chcesz podłączyć debugger to musisz teraz w intellij skonfigurować "remote debugging"
   1. O tym w sekcji [Debugowanie](#debugowanie)


Drugi sposób, czyli zbudowanie w kompletnie czystym środowisku:

1. Sklonuj to repozytorium
2. Będąc w głównym katalogu tego repozytorium wykonaj: `docker-compose up --build -f docker-compose.cleanBuild.yml`

### Debugowanie
