
function fn_Redirecciona(page){
    window.location=page+'/index.jsp?faces-redirect=true';
}

function validarIngresarFormato(xhr, status, args) {
    if (args.validado) {
        wAsociarFormatoAgregar.hide();
    } else {
        wSeleccionFormato.show();
    }
}

function validarVistaPreviaFormato(xhr, status, args) {
    if (args.validado) {
        document.getElementById("frmSubirFormato:cmdVerFormato").click();
    } else {
        wSeleccionFormato.show();
    }    
}

function ocultarMensajesFilicacion() {
    document.getElementById("mensajesFilicacionImportar").style.display = "none";
    document.getElementById("logFilicacionImportar").style.display = "none";
}


function validarCheckHabilitar(idObjDiv, idObjDivCheck) {
    var objDivCheck = document.getElementById(idObjDivCheck);
    var objCheck = objDivCheck.childNodes[0].childNodes[0].childNodes[0];    
    var estado = objCheck.checked;
    
    var objDiv = document.getElementById(idObjDiv);

    if(estado){
        objDiv.setAttribute("style","filter: alpha(opacity=100)");
        objDiv.setAttribute("style","opacity: 1.0");            
    }
    else{
        objDiv.setAttribute("style","filter: alpha(opacity=40)");
        objDiv.setAttribute("style","opacity: 0.4");            
    }

    habilitarObjeto(objDiv, estado);   
}

function validarManyCheckHabilitar(idObjDiv, idObjDivCheck) {
    var objDivCheck = document.getElementById(idObjDivCheck);
    var objManyCheck = objDivCheck.childNodes[0].childNodes[0].childNodes[0];    
    var len = objManyCheck.childNodes.length - 2;
    var objCheck = objManyCheck.childNodes[len].childNodes[0].childNodes[0].childNodes[0];
    var estado = objCheck.checked;

    var objDiv = document.getElementById(idObjDiv);

    if(estado){
        objDiv.setAttribute("style","filter: alpha(opacity=100)");
        objDiv.setAttribute("style","opacity: 1.0");            
    }
    else{
        objDiv.setAttribute("style","filter: alpha(opacity=40)");
        objDiv.setAttribute("style","opacity: 0.4");            
    }
    
    habilitarObjeto(objDiv, estado);
}

function cambiarEstadoObjeto(idObjDiv, estado) {
    var objDiv = document.getElementById(idObjDiv);

    if(estado){
        objDiv.setAttribute("style","filter: alpha(opacity=100)");
        objDiv.setAttribute("style","opacity: 1.0");            
    }
    else{
        objDiv.setAttribute("style","filter: alpha(opacity=40)");
        objDiv.setAttribute("style","opacity: 0.4");            
    }

    habilitarObjeto(objDiv, estado);   
}

function cambiarSoloLecturaObjeto(idObjDiv, estado) {
    if(estado){
        objDiv.setAttribute("style","filter: alpha(opacity=100)");
        objDiv.setAttribute("style","opacity: 1.0");            
    }
    else{
        objDiv.setAttribute("style","filter: alpha(opacity=40)");
        objDiv.setAttribute("style","opacity: 0.4");            
    }

    soloLecturaObjeto(idObjDiv, estado);   
}

function habilitarObjeto(el, estado) {
    try {
        el.disabled = !estado;        
    }
    catch(E){
    }
    if (el.childNodes && el.childNodes.length > 0) {
        for (var x = 0; x  < el.childNodes.length; x++) {
            var hijo = el.childNodes[x];
            habilitarObjeto(hijo, estado);
        }
    }
}

function soloLecturaObjeto(idObjDiv, estado) {
    var el = document.getElementById(idObjDiv);
    try {
        el.readOnly = !estado;        
    }
    catch(E){
    }
    if (el.childNodes && el.childNodes.length > 0) {
        for (var x = 0; x  < el.childNodes.length; x++) {
            var hijo = el.childNodes[x];
            soloLecturaObjeto(hijo, estado);
        }
    }
}

function init() {
    scheduler.locale.labels.timeline_tab = "Trazabilidad";
    scheduler.locale.labels.section_custom="Section";
    scheduler.config.first_hour = 6;
    scheduler.config.last_hour = 20;
    scheduler.config.readonly = true;
    scheduler.config.xml_date="%Y-%m-%d %H:%i";

    //===============
    //Configuration
    //===============
    var sections=[
        {key:1, label:"Adofo Espinoza", open: true, children: [
            {key:2, label:"Programación"},
            {key:3, label:"Triaje"},
            {key:4, label:"Examen Físico"},
            {key:5, label:"Funciones Vitales"},
            {key:6, label:"Examen Audiometría"},
            {key:7, label:"Espirometría"},
            {key:8, label:"Examen Odontológico"},
            {key:9, label:"Mamografía"},
            {key:10, label:"Aptitud"}
        ]}
    ];
			
    //===============
    // Tooltip related code
    //===============

    // we want to save "dhx_cal_data" div in a variable to limit look ups
    var scheduler_container = document.getElementById("scheduler_here");
    var scheduler_container_divs = scheduler_container.getElementsByTagName("div");
    var dhx_cal_data = scheduler_container_divs[scheduler_container_divs.length-1];

    // while target has parent node and we haven't reached dhx_cal_data
    // we can keep checking if it is timeline section
    dhtmlxTooltip.isTooltipTarget = function(target) {
        while (target.parentNode && target != dhx_cal_data) {
            var css = target.className.split(" ")[0];
            // if we are over matrix cell or tooltip itself
            if (css == "dhx_matrix_scell" || css == "dhtmlXTooltip") {
                return { classname: css };
            }
            target = target.parentNode;
	}
	return false;
    };

    scheduler.attachEvent("onMouseMove", function(id, e) {
        var timeline_view = scheduler.matrix[scheduler.getState().mode];
	// if we are over event then we can immediately return
	// or if we are not on timeline view
	if (id || !timeline_view) {
            return;
	}
        // native mouse event
	e = e||window.event;
	var target = e.target||e.srcElement;
        var tooltipTarget = dhtmlxTooltip.isTooltipTarget(target);
	if (tooltipTarget) {
            if (tooltipTarget.classname == "dhx_matrix_scell") {
            // we are over cell, need to get what cell it is and display tooltip
                var section_id = scheduler.getActionData(e).section;
		var section = timeline_view.y_unit[timeline_view.order[section_id]];

		// showing tooltip itself
		var text = ""+section.label+"";
		dhtmlxTooltip.delay(dhtmlxTooltip.show, dhtmlxTooltip, [e, text]);
            }
            if (tooltipTarget.classname == "dhtmlXTooltip") {
                dhtmlxTooltip.delay(dhtmlxTooltip.show, dhtmlxTooltip, [e, dhtmlxTooltip.tooltip.innerHTML]);
            }
	}
    });
			
    scheduler.createTimelineView({
        name:	"timeline",
        x_unit:	"hour",
        x_date:	"%H:%i",
        x_step:	2,
        x_size: 24,
        x_start: 0,
        x_length:	24,
        y_unit:	sections,
        y_property:	"section_id",
        render:"tree",
        section_autoheight: false,
        folder_dy:20,
        dy:30,
        second_scale:{
            x_unit: "day", // unit which should be used for second scale
            x_date: "%F %d" // date format which should be used for second scale, "July 01"
        }
    });
    //===============
    //Data loading
    //===============
    scheduler.config.lightbox.sections=[
        {name:"description", height:100, map_to:"text", type:"textarea" , focus:true},
        {name:"custom", height:23, type:"select", options:sections, map_to:"section_id" },
        {name:"time", height:52, type:"time", map_to:"auto"}
    ];

    scheduler.init('scheduler_here',new Date(2009,5,30),"timeline");
    scheduler.parse([
        { start_date: "2009-06-30 08:00", end_date: "2009-06-30 08:00", text:"", section_id:2, color:"green"},
        { start_date: "2009-06-30 08:00", end_date: "2009-06-30 11:00", text:"", section_id:3},
        { start_date: "2009-06-30 11:00", end_date: "2009-06-30 13:00", text:"", section_id:4},
        { start_date: "2009-06-30 14:00", end_date: "2009-06-30 16:00", text:"", section_id:5},
        { start_date: "2009-06-30 16:00", end_date: "2009-06-30 18:00", text:"", section_id:6},
	{ start_date: "2009-07-01 08:00", end_date: "2009-07-01 10:00", text:"", section_id:7},
	{ start_date: "2009-07-01 10:00", end_date: "2009-07-01 12:00", text:"", section_id:8},
	{ start_date: "2009-07-01 13:00", end_date: "2009-07-01 15:00", text:"", section_id:9},
        { start_date: "2009-07-01 13:00", end_date: "2009-07-01 15:00", text:"", section_id:10, color:"red"}
    ],"json");
}