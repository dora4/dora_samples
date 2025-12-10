package com.example.dcache.db.converter

import com.example.dcache.db.model.TestCaseModel
import dora.db.converter.PropertyConverter

/**
 * 仅演示写法。
 */
class TestCaseModelConverter : PropertyConverter<TestCaseModel, String> {

    override fun convertToDatabaseValue(entityProperty: TestCaseModel?): String? {
        if (entityProperty != null) {
            return entityProperty.stringVal
        }
        return null
    }

    override fun convertToEntityProperty(databaseValue: String?): TestCaseModel? {
        if (databaseValue != null) {
            return TestCaseModel(stringVal = databaseValue)
        }
        return null
    }
}