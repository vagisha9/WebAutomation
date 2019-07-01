package net.Touchtunes.common

class PropertiesKt : java.util.Properties() {
	init {
		this.load(java.io.FileInputStream("src/test/resources/test.properties"))
	}
}