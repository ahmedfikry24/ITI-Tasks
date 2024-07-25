package org.example.library_system.exceptions

abstract class BaseError(massage: String? = null) : Exception(massage)
class InvalidType(massage: String? = null) : BaseError(massage)
class NOLibrarianFound(massage: String? = null) : BaseError(massage)
class NOUserFound(massage: String? = null) : BaseError(massage)
class InvalidLibrarianLogin(massage: String? = null) : BaseError(massage)
class InvalidLibrarianOrder(massage: String? = null) : BaseError(massage)
class InvalidAddItemType(massage: String? = null) : BaseError(massage)
class UnAvailableItem(massage: String? = null) : BaseError(massage)
class NoBorrowedItemFound(massage: String? = null) : BaseError(massage)
class InvalidUserOrder(massage: String? = null) : BaseError(massage)