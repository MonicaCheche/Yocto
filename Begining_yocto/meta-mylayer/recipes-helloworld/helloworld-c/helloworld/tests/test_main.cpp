#include <gtest/gtest.h>
#include "mylib.h"

// test module2 addition function
TEST(MyLibTest, AdditionWorks) {
    EXPECT_EQ(MyProject::add(10, 5), 15);
    EXPECT_EQ(MyProject::add(-1, 1), 0);
}

// 
int main(int argc, char **argv) {
    ::testing::InitGoogleTest(&argc, argv);
    return RUN_ALL_TESTS();
}
