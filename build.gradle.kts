import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
//import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
	id("org.springframework.boot") version "2.6.6"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.6.10"
	kotlin("plugin.spring") version "1.6.10"
	id("com.palantir.docker") version "0.33.0"
	id("com.palantir.docker-run") version "0.33.0"
}

group = "br.com.thd"
version = "1.0"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("mysql:mysql-connector-java")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	//implementation("com.spotify:dockerfile-maven-plugin:1.4.13")


	testImplementation("org.springframework.boot:spring-boot-starter-test")

}



tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

//docker {
  //name = "${project.name}:".plus(version)
	//setDockerfile(file("Dockerfile"))
	//name = "${project.name}"
    //uri("mrkulli/ktdemo:".plus(version))
    //tag("name", "apibanco")
    //buildArgs(ImmutableMap.of("name", "ktdemo"))
		//buildArgs(mapOf("JAR_FILE" to "apibanco1.0.jar"))

    //copySpec.from("build").into("build")
    //pull(true)
		//files("apibanco-1.0.jar")
	//copySpec.from(jar). rename(".*", "app.jar")
	//buildArgs(["JAR_FAILE":"app.jar"])
    
//}

docker {
	name = "apibanco"
	files("teste.txt")
}

dockerRun {
    name = "app-banco"
    image = "${project.name}:".plus(version)
    ports("8080:8080")
    env(mapOf("SPRING_PROFILES_ACTIVE" to "dev"))
    daemonize = true
    clean = false
}
