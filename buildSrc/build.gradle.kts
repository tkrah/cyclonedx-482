plugins {
	`kotlin-dsl-base`
}

dependencies {
	implementation(gradleApi())
	implementation(libs.node.plugin)
}

val javaVersion = JavaVersion.VERSION_21

allprojects {
	tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
		kotlinOptions {
			jvmTarget = javaVersion.toString()
		}
	}
}

java {
	sourceCompatibility = javaVersion
	targetCompatibility = javaVersion
}
