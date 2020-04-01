##!/bin/bash
chmod +x *.sh
kotlinc -d out/AppCli.jar -include-runtime src -cp lib/kotlinx-cli-0.2.1.jar