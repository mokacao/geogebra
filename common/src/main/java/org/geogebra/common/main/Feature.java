package org.geogebra.common.main;

public enum Feature {
	ALL_LANGUAGES,

	LOCALSTORAGE_FILES,

	TUBE_BETA,

	EXERCISES,

	TOOL_EDITOR,

	DATA_COLLECTION,

	IMPLICIT_SURFACES,

	CONTOUR_PLOT_COMMAND,

	LOG_AXES,

	HIT_PARAMETRIC_SURFACE,

	PARAMETRIC_SURFACE_IS_REGION,

	ACRA,

	ANALYTICS,

	SAVE_SETTINGS_TO_FILE,

	HANDWRITING,

	AV_DEFINITION_AND_VALUE,

	CONVEX_HULL_3D,

	/** GGB-334, TRAC-3401 */
	ADJUST_WIDGETS,

	/** GGB-944 */
	EXPORT_ANIMATED_PDF,

	/** GGB-776 */
	ABSOLUTE_TEXTS,

	/** MOB-788 */
	MOBILE_USE_FBO_FOR_3D_IMAGE_EXPORT,

	/** GGB-1263 */
	AUTOSCROLLING_SPREADSHEET,

	/** GGB-1252 */
	KEYBOARD_BEHAVIOUR,

	/** GGB-2336 */
	KEYBOARD_ATTACHED_TO_TABLET,

	/** MOW */
	WHITEBOARD_APP,

	/**
	 * GGB-1398 + GGB-1529
	 */
	SHOW_ONE_KEYBOARD_BUTTON_IN_FRAME,

	/** MOW-97 */
	ERASER, ROUNDED_POLYGON,

	/** MOW-175 */
	MOW_CONTEXT_MENU,

	/** MOV-169 */
	DYNAMIC_STYLEBAR,

	/** MOW-29 */
	MOW_TOOLBAR,

	MOW_PEN_IS_LOCUS,

	MOW_PEN_EVENTS,

	/** MOW-105 */
	MOW_PEN_SMOOTHING,

	/** GGB-1617 */
	AUTOMATIC_DERIVATIVES,

	/** SolveQuartic in CAS GGB-1635 */
	SOLVE_QUARTIC,

	/** MOW-55 */
	MOW_BOUNDING_BOXES,

	/** MOW-320 */
	MOW_PIN_IMAGE,
	
	/** MOW-239 */
	MOW_IMPROVE_CONTEXT_MENU,

	/** MOW-251, MOW-197 */
	MOW_CLEAR_VIEW_STYLEBAR,

	/** MOW-197 */
	MOW_COLORPOPUP_IMPROVEMENTS,

	/** MOW-88 */
	MOW_DIRECT_FORMULA_CONVERSION,

	/** MOW-368 */
	MOW_IMAGE_DIALOG_UNBUNDLED,

	EXPORT_SCAD_IN_MENU,

	EXPORT_COLLADA_IN_MENU,

	EXPORT_OBJ_IN_MENU,

	/** GGB-1916 */
	DEFAULT_OBJECT_STYLES,
	
	/** GGB-2008 */
	OBJECT_DEFAULTS_AND_COLOR,

	SHOW_STEPS,

	/** GGB-1910 */
	LABEL_SETTING_ON_STYLEBAR,

	CENTER_STANDARD_VIEW,

	SURFACE_2D,

	/** GGB-1985*/
	FLOATING_SETTINGS,

	/** GGB-2005 */
	TOOLTIP_DESIGN,

	/** GGB-1986 */
	DIALOG_DESIGN,

	INITIAL_PORTRAIT,

	/** MOW-261 */
	MOW_COLOR_FILLING_LINE,

	/** MOW-269 */
	MOW_MULTI_PAGE,

	/** MOB-1293 */
	SELECT_TOOL_NEW_BEHAVIOUR,

	/** GGB-2183 change sin(15) -> sin(15deg) */
	AUTO_ADD_DEGREE,

	/** GGB-2222 change asin(0.5) -> asind(0.5) */
	CHANGE_INVERSE_TRIG_TO_DEGREES,

	/** MOB-1310 */
	SHOW_HIDE_LABEL_OBJECT_DELETE_MULTIPLE,

	/** MOB-1319 */
	MOB_NOTIFICATION_BAR_TRIGGERS_EXAM_ALERT_IOS_11,

	/** GGB-2215 */
	ARIA_CONTEXT_MENU,

	/** GGB-650 */
	GGB_WEB_ASSEMBLY,

	/** GGB-2394 */
	SPLITTER_LOADING,
	
	/** GGB-2439 */
	GRAPH_EXAM_MODE,

	/** MOW-285 */
	MOW_BOUNDING_BOX_FOR_PEN_TOOL,

	/** GBB-2374 */
	MAT_DESIGN_HEADER,

	/** MOW-360, MOW-381, MOW-382 */
	MOW_CROP_IMAGE,
	
	/** MOW-379, MOW-380 */
	MOW_IMAGE_BOUNDING_BOX,

	/** MOW-336 */
	MOW_DRAG_AND_DROP_PAGES,

	/** MOW-336 */
	MOW_DRAG_AND_DROP_ANIMATION,

	/** MOW-345 */
	MOW_MOVING_CANVAS,

	/** MOW-349 */
	MOW_AUDIO_TOOL,

	/** MOW-299 */
	MOW_VIDEO_TOOL,

	/** MOW-278 */
	MOW_HIGHLIGHTER_TOOL,

	/** MOW-459 */
	MOW_DOUBLE_CANVAS,

	/** MOW-348 */
	MOW_PDF_TOOL,

	MOW_GEOGEBRA_TOOL,

	/** MOW-479 */
	MOW_OPEN_FILE_VIEW,

	COMMAND_HOLES, WEB_CLASSIC_FLOATING_MENU,

	/** MOB-1537 */
	MOB_PREVIEW_WHEN_EDITING,

	/** GGB-2366 */
	TIKZ_AXES,

	/** AND-887 and IGR-732 */
	MOB_PROPERTY_SORT_BY,

	/** GGB-2375 */
	INPUT_BOX_LINE_UP_BETTER,

	/** GGB-2488 */
	SELECT_NEXT_GEO_IN_VIEW,

	/** MOB-1722 */
	MOB_EXPORT_STL,

	/** MOW-350 */
	MOW_EMBED_EXTENSION,

	/** MOW-491 */
	MOW_WIDGET_POSITIONS,

	/** MOW-533 */
	MOW_BACKGROUND,

	/** MOW-532 */
	MOW_BURGER_MENU_CLEANUP,
	
	/** MOW-484 */
	MOW_SHARE_DIALOG,

	/** MOW-189 */
	MOW_TEXT_TOOL,

	/** MOW-578 */
	MOW_SELECTION_TOOL,

	/** MOW-150 */
	MOW_ROTATION_HANDLER,

	/** MOW-626 */
	MOW_JOINT_SHARE_DIALOG,

	/** AND-1304 */
	MOB_LIST_TOOL,

	/** MOB-1771 */
	MOB_LIST_LABEL,

	/** AND-1342, IGR-1010 */
	MOB_STANDARD_VIEW_ZOOM_BUTTONS,

	/** AND-1400 */
	MOB_BACKGROUND_PROPERTY,

	/** AND-1217, IGR-931 */
	MOB_SCIENTIFIC_CALC_IN_APPS_MENU,

	/** AND-1323, IGR-987 */
	MOB_CAS_CALC_IN_APPS_MENU,

	/** MOB-1803 */
	MOB_ANGLE_DEGREES_MINUTES_SECONDS,

	/** GGB-2255 */
	GEOMETRIC_DISCOVERY,

	/** GGB-2525 */
	TAB_ON_EV_PLAY,

	/** AND-1372 */
	MOB_DEFAULT_ROUNDING_13,

	/** GGB-2538 */
	TOOLS_WITH_NAMES,

	/** GGB-2542 */
	SYMBOLIC_AV,

	/** APPS-83 */
	VOICEOVER_APPLETS,

	/** GGB-2517 */
	TOOLBAR_FROM_APPCONFIG,

	/** APPS-19 */
	TABLE_VIEW,

	/** G3D-6 **/
	DOWNLOAD_ARCORE,

	/** G3D-42 */
	G3D_AR_REGULAR_TOOLS,

	/** G3D-95*/
 	G3D_AR_ROTATE_3D_VIEW_TOOL,

	/** G3D-97*/
	G3D_AR_TRANSLATE_3D_VIEW_TOOL,

	/** automatically add NDG conditions in locus equations */
	LOCUSEQU_AUTO_NDG,

	/** APPS-31 */
	SPECIAL_POINTS_IN_CONTEXT_MENU,

	/** APPS-173 */
	POINTER_EVENTS,

	/** APPS-117 */
	FIX_EQUATIONS_AND_FUNCTIONS,

	/** G3D-89 */
	G3D_IOS_FASTER_AV,

	/** Csilla Master */
	SPEECH_RECOGNITION,

	/** G3D-131 */
	G3D_BLACK_AXES,

	/** APPS-250 */
	SHOW_DEFINITION_FOR_EQUATION_IN_EXAM,

    /** G3D-37 */
	G3D_PROJECTIONS_IN_SETTINGS,

	/** G3D-152 */
	G3D_IOS_AR_BACKGROUND
}

