# SDET3 – Test Automation Framework (Java)

Kapsam: **UI (Selenium)** + **API (Rest Assured)** + **POM** + **JUnit/TestNG** + **Maven**.
Amaç: İş görüşmelerinde “çalışır, anlaşılır, CI-ready” örnek bir SDET çerçevesi sunmak.

## 🚀 Hızlı Başlangıç

Önkoşullar: Java 17+, Maven.

```bash
mvn -B clean test -Denv=qa
```

Rapor dizini: `target/surefire-reports`
(İsteğe bağlı: Allure kullanıyorsan `allure serve target/allure-results`)

## 📁 Proje Yapısı

```
/src
  /test
    /java
      /.../pages         # Page Objects
      /.../steps         # Step Definitions / Test Classes
      /.../runners       # JUnit/TestNG runners
    /resources
      /features          # Gherkin (varsa)
      /config            # env dosyaları (qa, stage, prod)
pom.xml
```

## ⚙️ Konfigürasyon

* `-Denv=qa` ile ortam seçimi (örn. `qa.properties`, `stage.properties`)
* Base URL, credentials ve timeout değerlerini `resources/config` altına koy.

## 🧪 Örnek Senaryo (Gherkin)

```gherkin
Feature: Kullanıcı girişi
  Scenario: Geçerli kullanıcı ile giriş
    Given login sayfasındayım
    When kullanıcı adı ve şifreyi girerim
    Then ana sayfayı görmeliyim
```

## 🧱 Mimarî Notları (Özet)

* **POM (Page Object Model):** Tekrarlı locator ve akışlar tek yerde.
* **Utilities:** Wait, driver, request builder gibi yardımcı sınıflar.
* **Paralel Koşum:** Surefire/Failsafe ile ayarlanabilir.

## 🧰 Kullanılan Teknolojiler

* Java 17, Maven
* Selenium / WebDriverManager
* Rest Assured
* JUnit/TestNG
* (Opsiyonel) Allure, Mockito, WireMock

## 🧪 CI (GitHub Actions) Örneği

`.github/workflows/tests.yml`:

```yaml
name: CI
on:
  push:
  pull_request:
jobs:
  test:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v4
      - uses: actions/setup-java@v4
        with:
          distribution: temurin
          java-version: '17'
      - name: Cache Maven
        uses: actions/cache@v4
        with:
          path: ~/.m2/repository
          key: ${{ runner.os }}-m2-${{ hashFiles('**/pom.xml') }}
          restore-keys: |
            ${{ runner.os }}-m2-
      - name: Run tests
        run: mvn -B clean test -Denv=qa
      - name: Upload surefire reports
        uses: actions/upload-artifact@v4
        with:
          name: surefire-reports
          path: target/surefire-reports
```

## 🗺️ Yol Haritası

* [ ] GitHub Actions ile CI (rapor artifact’leri)
* [ ] Paralel test (Surefire `forkCount`, `threadCount`)
* [ ] Dockerized Selenium Grid
* [ ] Allure raporu + örnek ekran görüntüsü
* [ ] API mock (WireMock) ve negatif senaryolar

## 📜 Lisans

MIT (veya tercih ettiğin lisans).

# ![CI](https://github.com/erkankurtaga/SDET3/actions/workflows/tests.yml/badge.svg)
