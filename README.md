RPG made with Java & Slick2D library
====================================

### Setup to create a new Slick2D project
* Download the last version or Slick2D library on http://slick.ninjacave.com/
* In the root directory of your Java project :
	* Create `lib` directory
	* Put jinput.jar, lwjgl.jar & slick.jar files in this one
	* Create `lib/natives` directory
	* Put all .jnilib, .dll, .so, .dylib extensions files in this one
* Add jinput.jar, lwjgl.jar & slick.jar as libraries of the project
* Add **-Djava.library.path=lib/natives** option to Java VM arguments
* Slick2D is now configured. Work hard & have fun ! (: