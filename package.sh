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
  ICON=res/Tornukah.png
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
  ICON_WIN=res/Tornukah.png
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
  mkdir -p out/production/Microcraft
  mkdir -p out/artifacts/Microcraft_jar
  /usr/bin/javac -sourcepath src src/com/tornukah/microcraft/Main.java -d out/production/Microcraft
  cp -r res/ out/production/Microcraft/
  /usr/bin/jar -cmvf src/META-INF/MANIFEST.MF out/artifacts/Microcraft_jar/Microcraft.jar -C out/production/Microcraft/ .
  /usr/bin/jpackage --name MICROCRAFT --input out/artifacts/Microcraft_jar/ \
    --main-jar Microcraft.jar --main-class com.tornukah.microcraft.Main --resource-dir res --icon res/icon.icns
fi
