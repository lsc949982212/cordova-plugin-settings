var exec = require('cordova/exec');

exports.systemNoticeSetting = function (success, error) {
    exec(success, error, 'SystemSettings', 'systemNoticeSetting', []);
};
exports.securitySettings = function (success, error) {
    exec(success, error, 'SystemSettings', 'securitySettings', []);
};