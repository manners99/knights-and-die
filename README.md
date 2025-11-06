# Knights & Die

A small Java 21 project skeleton for learning JavaFX + Hibernate + H2/SQLite.

What's included

- Maven build (Java 21)
- JavaFX (via OpenJFX)
- Hibernate ORM (Hibernate 6)
- H2 in-memory default configuration
- SQLite available via dependency (see notes)
- A simple `Knight` entity and a JUnit 5 test
- GitHub Actions workflow to build & test on push

Quick start

1. Build the project (requires Maven and JDK 21):

```powershell
cd "c:\Users\jmann\Downloads\GitRepos\Personal Projects\Knights & Die"
mvn -B package
```

2. Run the JavaFX app via the plugin (or from your IDE):

```powershell
mvn javafx:run
```

3. To run tests:

```powershell
mvn test
```

Notes

- The default DB is H2 in-memory (configured in `src/main/resources/hibernate.cfg.xml`).
- To use SQLite instead, update `hibernate.cfg.xml` properties:
  - driver: `org.sqlite.JDBC`
  - dialect: `org.hibernate.dialect.SQLiteDialect` (you may need a community dialect)
  - url: `jdbc:sqlite:knights.db`

- IntelliJ: open the folder as a project; it will detect Maven and import modules.
