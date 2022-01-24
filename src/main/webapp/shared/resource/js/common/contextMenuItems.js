/**
 * Predefined context menu items
 */
var ctxMenu = {
	// LoggedIn global menu
	loggedInUser : [{
		name:com.caption.ctxMyProfile,
		img:jsconfig.get("imgThemeCom")+"/icnUser-MyProfile_Black.png",
//		title:"My Profile",
		fun:function() {}
	}, {
		name:com.caption.ctxLogOut,
		img:jsconfig.get("imgThemeCom")+"/icnUser-LogOut_Black.png",
//		title:"Log Out",
		fun:function() {}
	}],

	// LoggedIn global menu for Administrator
	loggedInUserForAdmin : [{
		name:com.caption.ctxMyProfile,
		img:jsconfig.get("imgThemeCom")+"/icnUser-MyProfile_Black.png",
		fun:function() {}
	}, {
		name:"Change User",
		img:jsconfig.get("imgThemeCom")+"/icnUserGroup-MyProfile_Black.png",
		fun:function() {}
	}, {
		name:com.caption.ctxLogOut,
		img:jsconfig.get("imgThemeCom")+"/icnUser-LogOut_Black.png",
		fun:function() {}
	}],

	// Common action context menu
	commonAction : [{
		name:com.caption.ctxDetail,
		img:"fa-list-alt",
		fun:function() {}
	}, {
		name:com.caption.ctxEdit,
		img:"fa-edit",
		fun:function() {}
	}, {
		name:com.caption.ctxDelete,
		img:"fa-times",
		fun:function() {}
	}],

	// Common simple action context menu
	commonSimpleAction : [{
		name:com.caption.ctxEdit,
		img:"fa-edit",
		fun:function() {}
	}, {
		name:com.caption.ctxDelete,
		img:"fa-times",
		fun:function() {}
	}],

	// Export context menu
	commonExport : [{
		name:com.caption.ctxExportExcelAll,
		fileType:"Excel",
		dataRange:"All",
		img:"fa-file-excel-o",
		fun:function() {}
	}, {
		name:com.caption.ctxExportExcelCurrentPage,
		fileType:"Excel",
		dataRange:"Current",
		img:"fa-file-excel-o",
		fun:function() {}
	}, {
		name:com.caption.ctxExportPdfAll,
		fileType:"PDF",
		dataRange:"All",
		img:"fa-file-pdf-o",
		fun:function() {}
	}, {
		name:com.caption.ctxExportPdfCurrentPage,
		fileType:"PDF",
		dataRange:"Current",
		img:"fa-file-pdf-o",
		fun:function() {}
	}, {
		name:com.caption.ctxExportHtmlAll,
		fileType:"HTML",
		dataRange:"All",
		img:"fa-file-code-o",
		fun:function() {}
	}, {
		name:com.caption.ctxExportHtmlCurrentPage,
		fileType:"HTML",
		dataRange:"Current",
		img:"fa-file-code-o",
		fun:function() {}
	}],

	// Board(Notice, BBS) Action context menu
	boardAction : [{
		name:com.caption.ctxDetail,
		img:"fa-list-alt",
		fun:function() {}
	}, {
		name:com.caption.ctxEdit,
		img:"fa-edit",
		fun:function() {}
	}, {
		name:com.caption.ctxReply,
		img:"fa-reply-all",
		fun:function() {}
	}, {
		name:com.caption.ctxDelete,
		img:"fa-times",
		fun:function() {}
	}],

	// Data Entry List Screen Action context menu
	dataEntryListAction : [{
		name:com.caption.ctxEdit,
		img:"fa-edit",
		fun:function() {}
	}, {
		name:com.caption.ctxDelete,
		img:"fa-trash",
		fun:function() {}
	}, {
		name:com.caption.ctxComplete,
		img:"fa-check-square",
		fun:function() {}
	}],

	// Data Entry Action context menu
	dataEntryAction : [{
		name:com.caption.ctxSave,
		img:"fa-save",
		fun:function() {}
	}, {
		name:com.caption.ctxCancel,
		img:"fa-refresh",
		fun:function() {}
	}, {
		name:com.caption.ctxDelete,
		img:"fa-trash",
		fun:function() {}
	}],
	
	// Additional service context menu (Quotation | Invoice)
	quoteInvoiceAction : [{
		name:com.caption.ctxEdit,
		img:"fa-edit",
		fun:function() {}
	}, {
		name:"Preview",
		img:"fa-search-plus",
		fun:function() {}
	}, {
		name:com.caption.ctxDelete,
		img:"fa-times",
		fun:function() {}
	}]
};