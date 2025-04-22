# Projet 2 POEI groupe 4
Ce répertoire contient le scripts d'automatisation de test en selenium du groupe 4 composé de Wafa ELMABROUK, Amy SEYE, Asanka VARRAT et Julien MICHEL pour le projet 2 de la POEI2025 dont le lien Jira est [ici](https://team-1612820401992.atlassian.net/jira/software/projects/POEI25P2G4/boards/280)
## Organisation du projet maven
Le projet est un projetmaven organisé de la façon suivante:
- Dans le dossier main:
    - Les pages contenant les localisateurs des éléments sur chaque page ainsi que les actions à effectuer sur ces éléments avec une classe BasePage permettant de rassembler les méthodes et éléments communs aux différentes pages
    - Des methodes générales telles que la lecture de configuration ou la génération de chaines de caractères aléatoires dans un dossier utils
    - Le fichier de configuration permettant de facilement changer ceratins paramètres tels que la navigateur ou l'exécution en arrière plan
- Dans le dossier test:
    - Un fichier Setup permettant de réaliser les actions à faire avant et après chacun des scripts de test comme l'ouverture et la fermeture du driver ainsi que la prise de capture d'écran en cas de test râté
    - Un fichier RunnerTest permettant de lancer l'ensemble des tests cucumber
    - Des fichiers steps permettant d'implémenter les actions des fichiers .feature à l'aide des méthodes définies dans les fichiers page
    - Un dossier features permettant d'accueillir tous les fichiers .feature. Ces fichiers ne sont pas présents sur github car lors d'un lancement avec Jenkins, ils sont automatiquement importés depuis XRAY
- En dehors de ces dossiers:
    - Une Jenkinsfile (JenkinsFile) permettant de lancer des tests provenant de multiples tests executions et de renvoyer les resultats dans ces memes tests executions
    - Une autre Jenkinsfile (JenkisnsFileFullReport) permettant de lancer un ensemble de test dont les résultats sont envoyés dans un seul test execution et, contrairement à la précédente, d'obtenir un rapport sur l'ensemble des tests effectués
    - Un fichier .gitignore pour filtrer les éléments à envoyer sur github
    - Un fichier pom.xml pour définir les dépendances qui sont:
        - Selenium
        - Cucumber-Java
        - Cucmber-Junit
        - Commons
## Exécutions des scripts
Les scripts peuvent être lancé depuis n'importe quelle machine possédant java, les étapes à faire sont alors les suivantes:
1. Télécharger le projet depuis github
2. Télécharger les features à tester depuis XRAY
3. Déplacer les features dans le dossier src/test/resources/features
4. (Optionnel) Modifier le fichier de configuration pour avoir les paramètres souhaités
5. Exécuter la classe runnerTest ou lancer un mvn test

Il est également possible de lancer les tests depuis Jenkins:
1. Créer une pipeline Jenkins configurée en SCM git qui pointe vers ce répertoire github
2. Chosir la JenkinsFile souhaitée (JenkinsFile ou JenkisnsFileFullReport)
3. Lancer une première fois la pipeline "Dans le vide" pour permettre le choix des paramètres
4. Cliquer sur "Lancer un build avec des paramètres" puis choisir les paramètres à lancer dont les clés des tests executions sont trouvables dans ce [filtre](https://team-1612820401992.atlassian.net/issues/?filter=12068)

Avec les deux méthodes d'exécutions, les tests peuvent être lancés sur un Grid en changeant les propriétés dans le fichier config.properties ou en changeant les paramètres depuis la pipeline.
Dans ce cas les paramètres à entrer pour le navigateur sont chrome, MicrosoftEdge ou firefox