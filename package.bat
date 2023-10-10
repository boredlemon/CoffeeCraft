mkdir out\production\Coffeecraft
mkdir out\artifacts\Coffeecraft_jar
javac -sourcepath src src\com\coffee\coffeecraft\Main.java -d out\production\Coffeecraft
mkdir out\artifacts\Coffeecraft\res
xcopy /s /e res out\production\Coffeecraft\res
jar -cmvf src\META-INF\MANIFEST.MF out\artifacts\Coffeecraft_jar\Coffeecraft.jar -C out\production\Coffeecraft\ .
jpackage --name COFFEECRAFT --input out\artifacts\Coffeecraft_jar\ --main-jar Coffeecraft.jar --main-class com.coffee.coffeecraft.Main --resource-dir res --icon res\icon.ico