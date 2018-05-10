# scala-archetype

A Maven archetype to boostrap Scala projects.

## Supported versions

- **Java** : only JDK 8
- **Scala** : only `2.10.x`, `2.11.x` and `2.12.x`

## Generate a Scala project

### Properties

#### Required

The required properties are :

| Property name  | Example        |
|:-------------- |:-------------- |
| `groupId`      | `com.example`  |
| `artifactId`   | `my-project`   |
| `version`      | `1.0-SNAPSHOT` |
| `author`       | `norbjd`       |
| `scalaVersion` | `2.11.8`       |

#### Optional

There are also optional properties :

| Property name      | Example                                      |
|:------------------ |:-------------------------------------------- |
| `name`             | `My Scala project`                           |
| `description`      | `A simple Scala project`                     |
| `scmUrl`           | `https://github.com/norbjd/my-scala-project` |
| `organizationName` | `norbjd`                                     |
| `organizationUrl`  | `https://github.com/norbjd`                  |

By default, the values of these properties are generated from the
required properties, but you can override them by setting them
explicitly during project generation.

### Generate my project

Interactive mode :

    mvn archetype:generate \
        -DarchetypeGroupId=com.norbjd.maven \
        -DarchetypeArtifactId=scala-archetype \
        -DarchetypeVersion=1.0-SNAPSHOT

Batch mode (specify required properties in command line) :

    mvn -B archetype:generate \
            -DarchetypeGroupId=com.norbjd.maven \
            -DarchetypeArtifactId=scala-archetype \
            -DarchetypeVersion=1.0-SNAPSHOT
            -DgroupId=com.example \
            -DartifactId=my-project \
            -Dversion=1.0-SNAPSHOT \
            -Dauthor=myself \
            -DscalaVersion=2.11.8

Try it out!

## Features and used tools

### Compilation

Multiple options are passed for the compilation of Scala classes
(using [`scala-maven-plugin`](https://github.com/davidB/scala-maven-plugin)),
like `-Xfatal-warning`, `-Ywarn-dead-code`, ... (you can find them
by looking at the `pom.xml` in `archetype-resources`).

All these options are deliberately restrictive to ensure code quality.
I do not encourage you to change them, but rather respect them.

### Style

- Linter : [`scapegoat`](https://github.com/sksamuel/scapegoat)
- Style : [`scalariform`](https://github.com/tashoyan/scalariform-maven-plugin)

Linter warnings and Scalariform style settings can be tuned, but the
defaults ensure that strict validation is done.

### Tests

Unit tests and integration tests are dissociated :

- `src/test/scala` for unit tests
- `src/it/scala` for integration tests

For all tests, the following tools are used :

- [`scalatest`](https://github.com/scalatest/scalatest) for writing
tests
- [`scoverage`](https://github.com/scoverage/scoverage-maven-plugin)
for code coverage
- [`surefire`](https://maven.apache.org/surefire/maven-surefire-plugin/)
and [`failsafe`](https://maven.apache.org/surefire/maven-failsafe-plugin/)
are preferred over Scalatest plugin because :
    - `failsafe` ensures that integration tests are run over packaged
    application
    - both have better integration in reporting

The counterpart of using `surefire` and `failsafe` with `scalatest` is
that all test classes must declare `@RunWith(classOf[JUnitRunner])` to
be run.

### Reporting

When running `mvn site`, 3 project reports are available :

- unit tests, with `Surefire`
- integration tests, with `Failsafe`
- code coverage, with `scoverage`

Moreover, the generated site is fully operational and use the fluido
skin.
