# STEP 1: Choose the base image. We need one with the JDK to compile and run.
FROM openjdk:17-jdk-slim

# STEP 2: Set the working directory inside the container. 
# All following commands will run from this path.
WORKDIR /app

# STEP 3: Copy the local file from your computer into the container's current directory (./)
# The first path is from your machine, the second is inside the container.
COPY Hello.java .

# STEP 4: Compile the Java file inside the container.
# This creates the 'hello.class' bytecode file.
RUN javac Hello.java

# STEP 5: Define the command to run when the container starts.
# This executes our Java program.
CMD ["java", "Hello"]
