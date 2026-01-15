# Hytale Example Plugin

*This example plugin has been forked from https://github.com/Build-9/Hytale-Example-Project*

An example project that can build and run plugins for Hytale.

## Introduction
This project contains a Gradle project that can be imported into IDEA and used
as the foundation for custom Hytale plugins. The template adds the Hytale
server to your classpath and create a run configuration that can be used to
run your plugin on the server. It can also be used to build a sharable JAR file
that contains your plugin.

## Requirements
Please ensure all the requirements are met before getting started.

1. Download Hytale using the official launcher.
2. Download IntelliJ IDEA.
3. Download Java 25 and set it as the SDK in IDEA.

## Downloading Template

It is highly recommended to **download** these files instead of cloning them. In GitHub, you can
download the entire repository as a `.zip` file and then begin using it.

This will ensure you are not making commits to the template repository and can create your own.

### Initializing Git

You should be using version control such as Git/GitHub for your mods. First, create an **empty** 
GitHub repository for your mod. Then open a command terminal in  your mod folder, and run the following:

```
git init
git add -A
git commit -m "Initial commit"
git remote add origin <link to GitHub repository>
git push --set-upstream origin main
```

Start with `git init` to create
a local git repository, then connect it to a remote GitHub repository.

## Configuring Template
It is important to configure the project before using it as a template. Doing
this before importing the project will help avoid running into caching issues
later on.

### 1. Project Name
Set the name of the project in `settings.gradle`. This should be the name of
your plugin. We recommend capitalizing your project name and avoiding 
whitespace and most special characters. This will be used as the base name for
any files produced by Gradle, like the sharable JAR file.

### 2. Gradle Properties
Review the properties defined in `gradle.properties`. You should change the 
`maven_group` to match your project. You should also change the `version`
property before making a new release, or set up CI/CD to automate it.

### 3: Manifest
The manifest file provides important information about your plugin to Hytale.
You should update every property in this file to reflect your project. The 
most important property to set is `Main` which tells the game which class
file to load as the entry point for your plugin. The file can be found at 
`src/main/resources/manifest.json`.

**This template has configured Gradle to automatically update the `Version` and
`IncludesAssetPack` property to reflect your Gradle properties every time you 
run the game in development, or build the plugin. This is a workaround to allow
the in-game asset editor to be used when working on your project.**

## Importing into IDEA
When opening the project in IDEA it should automatically create the
`HytaleServer` run configuration and a `./run` folder. When you run the game it
will generate all the relevant files in there. It will also load the default 
assets from the games.

**If you do not see the `HytaleServer` run configuration, you may need to open
the dropdown or click `Edit Configurations...` once to unhide it.**

## Importing into VSCode
While VSCode is not officially supported, you can generate launch configs by 
running `./gradlew generateVSCodeLaunch`.

## Connecting to Server
Once the server is running in IDEA you should be able to connect to 
`Local Server` using your standard Hytale client. If the server does not show
up automatically, add the IP as `127.0.0.1` manually.

### You MUST authenticate your test server!
In order to connect to the test server, you must authenticate it with Hytale.
This is done by running the `auth login device` command in the server terminal.
This command will print a URL that you can use to authenticate the server using
your Hytale account. Once authenticated, you can run the 
`auth persistence Encrypted` command to keep your server authenticated after 
restarting it. 

**Never share your encrypted auth file!**

If you are unable to run commands from the IDEA terminal, you can also run the 
command from code like this. Make sure to remove the code after your server is
authenticated.

```java
    @Override
    protected void start() {
        CommandManager.get().handleCommand(ConsoleSender.INSTANCE, "auth login device");
    }
```


## Verifying The Example Plugin
You can verify the Example plugin has loaded by running the `/test` command 
in game. It will print the name and version of your plugin. This is for 
demonstration purposes, and should **NOT** be included in your final build.

The example plugin also includes a recipe defined by an asset pack. This recipe
allows you to craft 10 dirt into 1 dirt using the crafting window. This is also
an example and should not be removed before you release the plugin.