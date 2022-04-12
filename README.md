### Git workflow

1. Sforkuj to repozytorium
2. Skonfiguruj gita aby podpisywał commity twoim imieniem, nazwiskiem i uczelnianym mailem
   1. `git config --global user.name "FIRST_NAME LAST_NAME"`
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


### Uruchamianie 
#### Uruchamianie lokalne
- **Docker** *(są dwa sposoby)*:


#### W intellij:

Na prawym panelu jest zakładka "Gradle", Tasks -> application -> run

#### W terminalu:

`./gradlew run`


- **Local z Keycloakiem**   
#### Ustawienie środowiska
1. Edytujemy konfigurację IntelliJ  
![](https://i.imgur.com/TXrYzgg.png)
2. W active profile wpisujemy local  
![](https://i.imgur.com/6c1IeBj.png)
3. Ustawiamy zmienne środowiskowe  
   1. Rozwijamy menu *Modify Options* (Alt + M)  
   ![](https://i.imgur.com/6c1IeBj.png)
   2. Wybieramy *Environment Variables* (Alt + E)  
   ![](https://i.imgur.com/9Vtuj5C.png)
   3. Ustawiamy zmienne środowiskowe
   ![](https://i.imgur.com/iMMrtZR.png)
   W *KEYCLOAK_SECRET* wpisujemy wartość z Keycloaka o tym później
4. Odpalamy lokalnie bazę danych i Keycloaka
   1. Otwieramy plik *docker-compose.devBuild.yml* w Intellij i odpalamy kontener database  
   ![](https://i.imgur.com/d1jhtzZ.png)
   2. Odpalamy Keycloaka  
   ```shell
   docker run -p 8081:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:17.0.1 start-dev
   ```
   Teraz Keycloak powinien działać na porcie 8081  
   3. Wchodzimy na [Keycloak](http://localhost:8081)
   4. Klikamy Administrator Console i logujemy się jako **admin** z hasłem **admin**
   5. Z panelu po lewej stronie wybieramy **Import**
   ![](https://i.imgur.com/03SiVsl.png)  
   I importujemy plik *realm-export.json*
5. Wchodzimy w zakładkę **Clients** w panelu i wybieramy klienta **backend** 
   1. Upewniamy się, czy opcja **Service Account** jest włączona  
   ![](https://i.imgur.com/Ob2E6c9.png)
   2. Wchodzimy w zakładkę **Credentials**  
   ![](https://i.imgur.com/V3WK7Xi.png)  
   I kopiujemy Client Secret i tę wartość podajmy w zmiennej środowiskowej **KEYCLOAK_SECRET** 
6. Uruchamiamy serwer backendowy przez IntelliJ
![](https://i.imgur.com/DfmyuGR.png)  
  
Teraz powinien działać backend wraz ze skonfigurowanym Keycloakiem
### Debugowanie
=======
---
#### Testowanie:

#### W intellij:

Na prawym panelu jest zakładka "Gradle", Tasks -> verification -> run

#### W terminalu:

`./gradlew test`

