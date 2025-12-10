package com.example.dcache.db.converter

import com.example.dcache.db.model.TestCaseModel
import dora.db.converter.BaseJsonConverter
import dora.db.converter.PropertyConverter

/**
 * PropertyConverter<TestCaseModel, String>接口也要实现，用于被反射监测到。
 */
class TestCaseModelJsonConverter : BaseJsonConverter<TestCaseModel>(),
    PropertyConverter<TestCaseModel, String> {
}