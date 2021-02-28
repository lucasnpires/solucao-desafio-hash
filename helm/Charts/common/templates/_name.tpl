{{- define "common.helm" -}}
app.kubernetes.io/instance: {{ .Release.Name }}
app.kubernetes.io/managed-by: {{ .Release.Service }}
app.kubernetes.io/version: {{ .Chart.AppVersion | replace "+" "_" | trunc 63 | quote }}
app.kubernetes.io/name: {{ include "common.helm.name" . }}
helm.sh/chart: {{ include "common.helm.chart.name" . }}
{{- end }}

{{- define "common.name.value" -}}
{{ .Release.Name | trunc 63 | trimSuffix "-" }}
{{- end }}

{{- define "common.name.version.value" -}}
{{ .version | replace "." "-" }}
{{- end }}

{{- define "common.name.namespace" -}}
{{- if .name }}
{{- printf "%s-%s" (include "common.name.value" .) .name }}
{{- else }}
{{- include "common.name.value" . }}
{{- end }}
{{- end }}

{{- define "common.registry.secret" }}
{{- printf "{\"auths\": {\"%s\": {\"auth\": \"%s\"}}}" .server (printf "%s:%s" .username .password | b64enc) | b64enc }}
{{- end }}