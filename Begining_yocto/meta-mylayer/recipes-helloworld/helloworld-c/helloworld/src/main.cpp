#include "mylib.h"
#include <iostream>

int main() {
    std::cout << "--- start project ---" << std::endl;
    
    MyProject::printModule1();
    
    int result = MyProject::add(20, 26);
    std::cout << "calculate the result (20+26): " << result << std::endl;
    
    return 0;
}
