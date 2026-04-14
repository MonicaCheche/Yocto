# meta-mylayer

## 📝 Introduction
**meta-mylayer** is a demonstration Yocto layer designed to showcase best practices for integrating different C/C++ build systems. It serves as a professional reference for:
* **Modern C++**: Integration of **CMake** with **Google Test (GTest)**.
* **Legacy/Simple C**: Integration of traditional **Makefiles** with correct cross-compilation variables.
* **Package Splitting**: Separating main executables from test suites (`-tests` packages).

---

## 📂 Layer Structure
```text
meta-mylayer/
├── conf/
│   └── layer.conf              # Layer configuration
├── recipes-helloworld/
│   ├── helloworld-c/           # CMake + GTest example
│   │   ├── helloworld/         # Source directory (CMakeLists.txt, src, tests)
│   │   └── helloworld-c.bb     # Recipe using 'inherit cmake'
│   └── helloworld-m/           # Makefile example
│       ├── helloworld/         # Source directory (Makefile, helloworld.c)
│       └── helloworld-m.bb     # Recipe using 'oe_runmake'
└── README.md


## 🧩 Dependencies
This layer relies on the standard OpenEmbedded and Yocto Project metadata. Ensure you have the following layers in your `bblayers.conf`:

* **meta-poky** (part of the Poky distribution)
* **openembedded-core** (meta)
* **meta-oe** (optional, but recommended for GTest support)

| Layer | URI | Branch |
| :--- | :--- | :--- |
| **openembedded-core** | `git://git.openembedded.org/openembedded-core` | `kirkstone` |
| **meta-openembedded** | `git://git.openembedded.org/meta-openembedded` | `kirkstone` |

---

## 🛠️ Technical Details

### Build System Integration
The recipes in this layer demonstrate two different methods of handling source code:

1. **CMake (helloworld-c)**: 
   - Uses `inherit cmake` to handle the cross-compilation environment.
   - Links against `googletest` for unit testing.
   - Demonstrates how to split packages into `${PN}` and `${PN}-tests`.

2. **Makefile (helloworld-m)**:
   - Uses `oe_runmake` to pass variables.
   - Demonstrates passing `CC`, `CFLAGS`, and `LDFLAGS` from Yocto to a local Makefile.

### Package Splitting
By default, Yocto creates a single package. This layer uses the following logic to keep the image clean:
* `helloworld-c`: Main binary for production.
* `helloworld-c-tests`: Unit test binaries (not included in production unless requested).

---

## 📋 Compatibility
This layer is tested and compatible with the following Yocto releases:
* **Kirkstone (4.0 LTS)**
* **Mickledore (4.2)**
* **Scarthgap (5.0 LTS)**


---

## 🔍 Troubleshooting

### 1. License Check Failed
If you get a license error during `bitbake`, ensure your recipe has:
`LICENSE = "CLOSED"` or the correct path to a license file. This layer uses `CLOSED` for demo purposes.

### 2. GTest Not Found
If `helloworld-c` fails to find GTest, make sure you have added `meta-oe` to your `bblayers.conf`. The recipe relies on:
```bitbake
DEPENDS += "googletest"


###3. Permission Denied (QEMU)
If you cannot run the binaries in QEMU, check if the execution bit was set during do_install:

Snippet di codice
```install -m 0755 MyExecutable ${D}${bindir}/MyExecutable ```

---

## 🚀 Installation & Usage

### 1. Add the Layer
Navigate to your Yocto build directory and run:
```bash
bitbake-layers add-layer ../meta-mylayer


# Add main applications
IMAGE_INSTALL:append = " helloworld-c helloworld-m"

# Add unit tests for the CMake project (Optional)
IMAGE_INSTALL:append = " helloworld-c-tests"


## 🧪 Testing on Target (QEMU)

Once the build is successful, follow these steps to verify the software on the emulated target:

### 1. Boot the Image
Run the following command in your host terminal:

```bash
runqemu qemux86-64 nographic

### 2. Execute Programs
Inside the QEMU terminal, test your integrated applications:

#### **CMake Project**
```bash
# Runs the main C++ application
MyExecutable

# Runs the GTest unit tests
TestMyLib

# Runs the simple C application
helloworld


