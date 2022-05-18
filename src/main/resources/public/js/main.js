// Check if the path is "/auction/1" and open the modal
if (window.location.pathname.split("").find(x => x === "/").length === 1) {
    $(document).ready(function () {
        $("#modalView").modal('show');
    });
}