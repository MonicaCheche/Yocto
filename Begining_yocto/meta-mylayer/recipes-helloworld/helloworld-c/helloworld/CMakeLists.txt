cmake_minimum_required(VERSION 3.10)
project(MyProject VERSION 1.0)    


set(CMAKE_CXX_STANDARD 11)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

#add source file: header nad source
add_library(MyLib STATIC src/lib/module1.cpp src/lib/module2.cpp)

add_executable(MyExecutable src/main.cpp)

#add the path of header for search
target_include_directories(MyLib PUBLIC ${CMAKE_SOURCE_DIR}/src/include)


#source

target_link_libraries(MyExecutable MyLib)


#---tests---

#find thread library
find_package(Threads REQUIRED)

#find Gtest package
find_package(GTest REQUIRED)

add_executable(TestMyLib tests/test_main.cpp)
#target_include_directories(TestMyLib PRIVATE ${GTEST_INCLUDE_DIRS})


#target_link_libraries(TestMyLib PRIVATE MyLib ${GTEST_LIBRARIES} Threads::Threads)
#better in yocto code is
target_link_libraries(TestMyLib PRIVATE MyLib GTest::gtest GTest::gtest_main Threads::Threads)

#record to add the dependence at the .bb:  DEPENDS += "googletest"

add_custom_command(
    TARGET MyExecutable
    POST_BUILD
    COMMAND ${CMAKE_COMMAND} -E echo "Build complete!"
)

# The command to define the target is only allowed when it is not cross-compiled (i.e., on the native Ubuntu machine).
if(NOT CMAKE_CROSSCOMPILING)
    add_custom_target(run
        COMMAND ${CMAKE_BINARY_DIR}/MyExecutable
        DEPENDS MyExecutable
        COMMENT "Running MyExecutable on Host..."
    )
endif()
