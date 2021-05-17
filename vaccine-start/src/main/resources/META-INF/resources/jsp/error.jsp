<%@ include file="header.jspf"%>
<%@ include file="navigation.jspf"%>
<div class="container">
    <div id='card' class="animated fadeIn">
        <div id='upper-side' class="error">
            <?xml version="1.0" encoding="utf-8"?>
            <svg version="1.1" id="checkmark" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" xml:space="preserve">
                    <circle fill="none" stroke="#ffffff" stroke-width="5" stroke-miterlimit="10" cx="109.486" cy="104.353" r="32.53" />
              </svg>
            <h3 id='status'>
                Error
            </h3>
        </div>
        <div id='lower-side'>
            <p id='message'>
                An exception occurred! Please contact Support!
            </p>
        </div>
    </div>
</div>
<%@ include file="footer.jspf"%>