package com.example.dcache.db.converter

import com.example.dcache.db.model.TestCaseModel
import dora.db.converter.BaseJsonConverter
import dora.db.converter.PropertyConverter

class TestCaseModelConverter : BaseJsonConverter<TestCaseModel>(),
    PropertyConverter<TestCaseModel, String> {
}