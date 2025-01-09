# BobTheExplorer

A turn-based RPG that takes players on a dungeon-exploring adventure. Developed by a group of students from University of Malaya for their WIX1002 Fundamentals of Programming course assignment.

## Installation

Dependencies:

- [SQLite JDBC](https://github.com/xerial/sqlite-jdbc) (3.47.0.0+)
- [Apache Commons Codec](https://github.com/apache/commons-codec) (1.17.1+)
- [JavaFX](https://gluonhq.com/products/javafx/) (21.0.5 LTS)
- [charm-glisten](https://nexus.gluonhq.com/nexus/content/repositories/releases/com/gluonhq/charm-glisten/6.1.0/) (6.1.0)

Clone this repository and add this to Java VM options:
```
--module-path "lib/javafx-sdk-21.0.5/lib" --add-modules javafx.controls,javafx.fxml,javafx.media --add-exports=javafx.base/com.sun.javafx=ALL-UNNAMED --add-exports=javafx.media/com.sun.media.jfxmedia=ALL-UNNAMED --add-exports=javafx.media/com.sun.media.jfxmedia.locator=ALL-UNNAMED
```

## Team Members

| | Division | Members | Job Description |
|-|----------|---------|-----------------|
|1| Database Manager | **Ong Yean** [24004532] | • Responsible for designing and developing the game database using SQL.<br> •	Ensures efficient data storage for player login credentials, scores, and other necessary data.<br> • Implements optimized and secure database interactions to support the gameplay. |
|2| Game Logic Developer | **Lee Jia Quan** [24004522]<br>**Tan Hong Ye** [24004580]<br>**Ong Yean** [24004532] | • Responsible for the development of core game mechanics, such as character movement, battle systems, and item system.<br> •	Develop important elements like database interactions and UI components to provide an interactive gaming experience.<br> • Ensures the logic runs smoothly and resolves any technical challenges during development.<br>• Debugging the whole program. |
|3| UI/UX Designer | **Tan Guan Zhe** [24004493]<br>**Eng Yi Fan** [24004550] | •	Creating an intuitive and user-friendly interface using JavaFX.<br> •	Develops the layouts and designs for menus, character creation screens, and in-game interactions like dungeon scenes to improve the visual appeal of the game.<br> • Ensures consistency in the design across all components of the game. |
|4| Documentation Specialist | **Eng Yi Fan** [24004550] | •	Responsible for documenting all aspects of the game development process and preparing the technical and managerial report.<br> •	Compiles technical details, such as database and system designs into the technical report.<br> •	Provides a detailed view of the project’s workflow. |



