# LibraryApp
Sovelluksen avulla käyttäjät pystyvät lisäämään kirjailijoita sekä kirjoja ja tarkastelemaan niitä erillisillä sivuilla

## Dokumentaatio

[Vaatimusmäärittely](./dokumentaatio/vaatimusmaarittely.md)

[Arkkitehtuurikuvaus](./dokumentaatio/arkkitehtuurikuvaus.md)

[Työaikakirjanpito](./dokumentaatio//tuntikirjanpito.md)

[Changelog](./dokumentaatio/changelog.md)

## Komentorivitoiminnot
Kaikki komennot ajetaan sovelluksen juurikansiossa /libraryapp
### Ohjelman suorittaminen
Ohjelma voidaan suoritta komennolla
```
mvn clean javafx:run
```
### Paketointi
Ohjelma voidaan paketoida suoritettavaan jar-tiedostoon /target/libraryapp-1.0-SNAPSHOT.jar komennolla
```
mvn package
```
Suoritettava jar-tiedosto voidaan suorittaa komennolla
```
java -jar ./target/libraryapp-1.0-SNAPSHOT.jar
```
### Testaus
Testit suoritetaan komennolla
```
mvn test
```
### Testikattavuus
Testikattavuusraportti generoidaan tiedostoon /target/site/jacoco/index.html komennolla
```
mvn test jacoco:report
```
### Checkstyle
Checkstyle tarkastuksen voi suorittaa komennolla
```
mvn jxr:jxr checkstyle:checkstyle
```

## Julkaisut
[viikko 5](https://github.com/melxi/ot-harjoitustyo/releases/tag/viikko5)  
[viikko 6](https://github.com/melxi/ot-harjoitustyo/releases/tag/viikko6)