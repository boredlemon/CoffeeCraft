#!/bin/bash

do_build=true
do_icon=true

while getopts 'bi' flag; do
  case "${flag}" in
    b) do_build=false ;;
    i) do_icon=false ;;
    *) exit 1 ;;
  esac
done

# Function to create macOS icon set
create_mac_icon() {
  ICONSET=res/icon.iconset
  ICON=res/coffee.png
  mkdir -p $ICONSET
  sizes=("16" "32" "64" "128" "256" "512" "1024")
  for size in "${sizes[@]}"; do
    sips -z $size $size $ICON --out $ICONSET/icon_${size}x${size}.png
  done
  iconutil -c icns $ICONSET
  rm -R $ICONSET
}

# Function to create Windows icon
create_windows_icon() {
  ICONSET=res/icon.iconset
  ICON_WIN=res/coffee.png
  convert \
    $ICONSET/icon_16x16.png \
    $ICONSET/icon_32x32.png \
    $ICONSET/icon_64x64.png \
    $ICONSET/icon_128x128.png \
    $ICONSET/icon_256x256.png \
    $ICON_WIN
}

if [ "$do_icon" = true ]; then
  create_mac_icon
  create_windows_icon
fi

if [ "$do_build" = true ]; then
  mkdir -p out/production/Coffeecraft
  mkdir -p out/artifacts/Coffeecraft_jar
  /usr/bin/javac -sourcepath src src/com/coffee/coffeecraft/Main.java -d out/production/Coffeecraft
  cp -r res/ out/production/Coffeecraft/
  /usr/bin/jar -cmvf src/META-INF/MANIFEST.MF out/artifacts/Coffeecraft_jar/Coffeecraft.jar -C out/production/Coffeecraft/ .
  /usr/bin/jpackage --name COFFEECRAFT --input out/artifacts/Coffeecraft_jar/ \
    --main-jar Coffeecraft.jar --main-class com.coffee.coffeecraft.Main --resource-dir res --icon res/icon.icns
fi
