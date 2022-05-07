package com.andro.spreadi18ncli

import com.andro.spreadi18ncore.Import
import java.lang.IllegalArgumentException
import java.nio.file.Path

class Main{
    companion object{

        @JvmStatic
        fun main(args: Array<String>){
            if (args.count() == 2) {
                val spreadsheetPath = Path.of(args[0])
                val projectPath = Path.of(args[1])
                println("Spreadsheet path: $spreadsheetPath, project path:$projectPath")
                Import.perform(sourceFilePath = spreadsheetPath, targetProjectPath = projectPath)
            } else {
                throw IllegalArgumentException("""Expect two arguments:
                | 1. A spreadsheet source file path,
                | 2. A project directory path.""".trimMargin())
            }
        }
    }
}
