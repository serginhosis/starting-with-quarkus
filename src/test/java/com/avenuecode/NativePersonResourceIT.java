package com.avenuecode;

import io.quarkus.test.junit.NativeImageTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@NativeImageTest
public class NativePersonResourceIT extends PersonResourceTest {

    // Execute the same tests but in native mode.

}